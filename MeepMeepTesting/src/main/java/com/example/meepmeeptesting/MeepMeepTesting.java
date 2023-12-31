package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.SampleMecanumDrive;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(326.725636, 26037.71398745077, Math.toRadians(150), Math.toRadians(150), 13)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-35, -62, -85))
                                // Line to the first stopping point (Right in front of the stage frame)
                                .lineToLinearHeading(new Pose2d(-35, -35, Math.toRadians(0)), SampleMecanumDrive.getVelocityConstraint(45, Math.toRadians(150), Math.toRadians(150)), SampleMecanumDrive.getAccelerationConstraint(26037.71398745077))
                                // Line to the second stopping point (Right beghind the of the stage frame)
//                                .lineToLinearHeading(new Pose2d(44,-35,0), SampleMecanumDrive.getVelocityConstraint(45, Math.toRadians(194.00321032258066), Math.toRadians(52.48291908330528)),SampleMecanumDrive.getAccelerationConstraint(52.48291908330528))
//                                .addTemporalMarker(2.50, () -> {
//                                    // This marker runs two seconds into the trajectory
//
//                                    // Run your action in here!
//                                })
//
//                                .lineToLinearHeading(new Pose2d(58,-60,0), SampleMecanumDrive.getVelocityConstraint(45, Math.toRadians(150), Math.toRadians(150)),SampleMecanumDrive.getAccelerationConstraint(26037.71398745077))
                                // .lineToLinearHeading(new Pose2d(-37, -62, 45), SampleMecanumDrive.getVelocityConstraint(45, Math.toRadians(150), Math.toRadians(150)),SampleMecanumDrive.getAccelerationConstraint(26037.71398745077))
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
