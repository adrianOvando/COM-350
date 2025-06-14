<?php

namespace App\Filament\Resources\TrainerWorkoutScheduleResource\Pages;

use App\Filament\Resources\TrainerWorkoutScheduleResource;
use Filament\Actions;
use Filament\Resources\Pages\ListRecords;

class ListTrainerWorkoutSchedules extends ListRecords
{
    protected static string $resource = TrainerWorkoutScheduleResource::class;

    protected function getHeaderActions(): array
    {
        return [
            Actions\CreateAction::make(),
        ];
    }
}
