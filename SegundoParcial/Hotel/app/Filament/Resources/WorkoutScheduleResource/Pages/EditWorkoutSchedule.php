<?php

namespace App\Filament\Resources\WorkoutScheduleResource\Pages;

use App\Filament\Resources\WorkoutScheduleResource;
use Filament\Actions;
use Filament\Resources\Pages\EditRecord;

class EditWorkoutSchedule extends EditRecord
{
    protected static string $resource = WorkoutScheduleResource::class;

    protected function getHeaderActions(): array
    {
        return [
            Actions\DeleteAction::make(),
        ];
    }
}
