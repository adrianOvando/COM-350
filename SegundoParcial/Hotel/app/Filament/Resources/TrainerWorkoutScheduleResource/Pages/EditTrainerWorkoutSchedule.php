<?php

namespace App\Filament\Resources\TrainerWorkoutScheduleResource\Pages;

use App\Filament\Resources\TrainerWorkoutScheduleResource;
use Filament\Actions;
use Filament\Resources\Pages\EditRecord;

class EditTrainerWorkoutSchedule extends EditRecord
{
    protected static string $resource = TrainerWorkoutScheduleResource::class;

    protected function getHeaderActions(): array
    {
        return [
            Actions\DeleteAction::make(),
        ];
    }
}
