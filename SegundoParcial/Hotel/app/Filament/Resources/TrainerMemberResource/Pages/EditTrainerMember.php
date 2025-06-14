<?php

namespace App\Filament\Resources\TrainerMemberResource\Pages;

use App\Filament\Resources\TrainerMemberResource;
use Filament\Actions;
use Filament\Resources\Pages\EditRecord;

class EditTrainerMember extends EditRecord
{
    protected static string $resource = TrainerMemberResource::class;

    protected function getHeaderActions(): array
    {
        return [
            Actions\DeleteAction::make(),
        ];
    }
}
